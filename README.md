# rubiconTest
Test task for *** company about reading data in different formats and writing it in given JSON format.

**Problem Statement**

Produce a program that consumes two input files and produces output according to the following specification

Takes two program arguments pathToDirectory and outputFile
The pathToDirectory consists of two files: input1.csv and input2.json
Writes output to the specified outputFile
Output: The output is a single file with one JSON object per line. Each JSON object, if pretty-printed, should look like the following object.

```
{
  "collectionId": "input1.csv",
  "sites": [
    {
      "id": "12344",
      "name": "example.com",
      "mobile": 1,
      "keywords": "sports,tennis,recreation",
      "score": 117.49
    },
    {
      "id": "12345",
      "name": "example.jp",
      "mobile": 1,
      "keywords": "japan,travel",
      "score": 38
    }
  ]
}
```

  Assume the keywords property is populated via a function which takes a "site" object and return a comma-delimited string. The implementation of the function is not essential to solution.

**Example Input** 
./src/test/resources/input

**Output file is stored here ./**

**Quick result review: mvn clean install**

