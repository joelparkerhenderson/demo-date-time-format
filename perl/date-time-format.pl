#!/usr/bin/env perl
use POSIX;
print strftime('%Y-%m-%dT%H:%M:%S.000000000Z', gmtime(time())), "\n";
