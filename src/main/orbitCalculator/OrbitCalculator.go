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

func makeSpaceObjects() {
	var spaceObjectRelations = make(map[string]string)

	file, err := os.Open("../resources/input.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	relationsMap := &spaceObjectRelations
	makeEmptySpaceObjects(file, relationsMap)
	// fmt.Print(relationsMap)
	appendChildOrbitObjects(relationsMap)
}

func makeEmptySpaceObjects(file io.Reader, relationsMap *map[string]string) *map[string]string {
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		lineRunes := []rune(scanner.Text())
		spaceObjectName := string(lineRunes[:3])
		spaceObjectChildName := string(lineRunes[4:])

		(*relationsMap)[spaceObjectChildName] = spaceObjectName
		spaceObjects[spaceObjectName] = newEmptySpaceObject(spaceObjectName)
		spaceObjects[spaceObjectChildName] = newEmptySpaceObject(spaceObjectChildName)
	}
	return relationsMap
}

func appendChildOrbitObjects(relationsMap *map[string]string) {
	for childName, parentName := range *relationsMap {
		var orbitParent = spaceObjects[parentName]
		var orbitChild = spaceObjects[childName]
		orbitChild.orbitParent = orbitParent
		orbitParent.orbitChildren = append(orbitParent.orbitChildren, orbitChild)
	}
}

func newEmptySpaceObject(spaceObjectName string) *spaceObject {
	return &spaceObject{
		name:          spaceObjectName,
		orbitParent:   nil,
		orbitChildren: make([]*spaceObject, 0),
	}
}

func main() {
	makeSpaceObjects()
	for _, spaceObject := range spaceObjects {
		fmt.Println(spaceObject.name, spaceObject.orbitParent)
	}
}
