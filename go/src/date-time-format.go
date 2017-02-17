package main

import "fmt"
import "time"

func main() {
    const f = "2006-01-02T15:04:05.999999999Z"
    t := time.Now().UTC()
    s := t.Format(f)
    fmt.Println(s)
}
