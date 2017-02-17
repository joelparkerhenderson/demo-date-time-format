#!/usr/bin/env python
import datetime
s = datetime.datetime.utcnow().strftime('%Y-%m-%dT%H:%M:%S.%f000Z')
print(s)
