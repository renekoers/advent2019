package main

import (
	"bufio"
	"fmt"
	"io"
	"log"
	"os"
)

var spaceObjects = make(map[string]*spaceObject)

type spaceObject struct {
	name          string
	orbitParent   *spaceObject
	orbitChildren []*spaceObject
}

func main() {
	makeSpaceObjects()
	sourceSpaceObject := findSourceSpaceObject()
	totalOfOrbits := 0
	sourceSpaceObject.addYourOrbitsToSourceToTotalAndAskChildren(sourceSpaceObject, &totalOfOrbits)
	fmt.Println(totalOfOrbits)

}

func makeSpaceObjects() {
	var spaceObjectRelations = make(map[string]string)

	file, err := os.Open("../resources/input.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	relationsMap := &spaceObjectRelations

	makeEmptySpaceObjects(file, relationsMap)
	createSpaceObjectRelationships(relationsMap)
}

func makeEmptySpaceObjects(file io.Reader, relationsMap *map[string]string) *map[string]string {
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		lineRunes := []rune(scanner.Text())
		spaceObjectParentName := string(lineRunes[:3])
		spaceObjectChildName := string(lineRunes[4:])

		(*relationsMap)[spaceObjectChildName] = spaceObjectParentName
		spaceObjects[spaceObjectParentName] = newSpaceObject(spaceObjectParentName)
		spaceObjects[spaceObjectChildName] = newSpaceObject(spaceObjectChildName)
	}
	return relationsMap
}

func createSpaceObjectRelationships(relationsMap *map[string]string) {
	for childName, parentName := range *relationsMap {
		var orbitParent = spaceObjects[parentName]
		var orbitChild = spaceObjects[childName]
		orbitChild.orbitParent = orbitParent
		orbitParent.orbitChildren = append(orbitParent.orbitChildren, orbitChild)
	}
}

func newSpaceObject(spaceObjectParentName string) *spaceObject {
	return &spaceObject{
		name:          spaceObjectParentName,
		orbitParent:   nil,
		orbitChildren: make([]*spaceObject, 0),
	}
}

func findSourceSpaceObject() (sourceSpaceObject *spaceObject) {
	for _, spaceObject := range spaceObjects {
		if spaceObject.orbitParent == nil {
			return spaceObject
		}
	}
	fmt.Println("Couldn't find a source!")
	return nil
}

func (thisSpaceObject *spaceObject) addYourOrbitsToSourceToTotalAndAskChildren(sourceSpaceObject *spaceObject, totalOfOrbits *int) {
	*totalOfOrbits = *totalOfOrbits + thisSpaceObject.getTotalOrbitsToSource()
	if len(thisSpaceObject.orbitChildren) != 0 {
		for _, spaceObjectOrbittingChild := range thisSpaceObject.orbitChildren {
			spaceObjectOrbittingChild.addYourOrbitsToSourceToTotalAndAskChildren(sourceSpaceObject, totalOfOrbits)
		}
	}
}

func (thisSpaceObject *spaceObject) getTotalOrbitsToSource() int {
	if thisSpaceObject.orbitParent != nil {
		return thisSpaceObject.orbitParent.getTotalOrbitsToSource() + 1
	}
	return 0
}
