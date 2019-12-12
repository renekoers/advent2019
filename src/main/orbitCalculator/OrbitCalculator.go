package main

import (
	"bufio"
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
	appendChildOrbitObjects(relationsMap)
}

func makeEmptySpaceObjects(file io.Reader, relationsMap *map[string]string) *map[string]string {
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		lineRunes := []rune(scanner.Text())
		spaceObjectName := string(lineRunes[:3])
		spaceObjectChildName := string(lineRunes[5:])

		(*relationsMap)[spaceObjectName] = spaceObjectChildName
		spaceObjects[spaceObjectName] = newEmptySpaceObject(spaceObjectName)
	}
	return relationsMap
}

func appendChildOrbitObjects(relationsMap *map[string]string) *map[string]string {
	for parentKey, childName := range *relationsMap {
		for spaceObjectKey, spaceObject := range spaceObjects {
			if parentKey == spaceObjectKey {
				childOrbitObject := newChildSpaceObject(childName, spaceObject)
				spaceObject.orbitChildren = append(spaceObject.orbitChildren, childOrbitObject)
				spaceObjects[spaceObject.name] = spaceObject
			}
		}
	}
	return relationsMap
}

func newEmptySpaceObject(spaceObjectName string) *spaceObject {
	return &spaceObject{
		name:          spaceObjectName,
		orbitParent:   nil,
		orbitChildren: make([]*spaceObject, 0),
	}
}

func newChildSpaceObject(spaceObjectName string, parent *spaceObject) *spaceObject {
	return &spaceObject{
		name:          spaceObjectName,
		orbitParent:   parent,
		orbitChildren: make([]*spaceObject, 0),
	}
}

func main() {
	makeSpaceObjects()

}
