# Go

Install and run:

    go install src/date-time-format.go 
    bin/date-time-format

If you get errors about the path, then you can set the path temporarily like this:

    GOPATH="$(pwd)" GOBIN="$(pwd)/bin" go install src/date-time-format.go
    bin/date-time-format