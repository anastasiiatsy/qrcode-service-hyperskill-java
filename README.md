**QRCode Service created as part of [Hyperskill](https://hyperskill.org/projects/385) Java Backend Developer (Spring Boot) track.**

**Demo:**
```
Examples:

Example 1. a GET request to /api/qrcode with a correct contents and default other parameters:

Request: GET /api/qrcode?contents=abcdef

Response code: 200 OK

Response header: Content-Type: image/png

Response body: byte array

Example 2. a GET request to /api/qrcode with an incorrect correction parameter:

Request: GET /api/qrcode?contents=abcde&correction=S

Response code: 400 BAD REQUEST

Response body:

{
    "error": "Permitted error correction levels are L, M, Q, H"
}

Example 3. a GET request to /api/qrcode with incorrect contents and correction parameters:

Request: GET /api/qrcode?contents=&correction=S

Response code: 400 BAD REQUEST

Response body:

{
    "error": "Contents cannot be null or blank"
}

Example 4. a GET request to /api/qrcode with an incorrect correction and type parameters:

Request: GET /api/qrcode?contents=abcde&correction=S&type=tiff

Response code: 400 BAD REQUEST

Response body:

{
    "error": "Permitted error correction levels are L, M, Q, H"
}
```
