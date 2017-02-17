# Demo Date Time UTC ISO format

This demo shows:

  * How to print a date-time string.
  * Using the UTC time zone, also known as GMT and Zulu time.
  * Using the ISO 8601 format, such as "YYYY-MM-DDT00:00:00.000000000Z"

Coding conventions in this repo.

  * `t` is the time.
  * `F` is the format string.
  * `s` is the output string.
  
Examples:

  * <a href="#bash">Bash</a>
  * <a href="#c">C</a>
  * <a href="#cpp">C++</a>
  * <a href="#csharp">C#</a>  
  * <a href="#elixir">Elixir</a>
  * <a href="#go">Go</a>
  * <a href="#haskell">Haskell</a>
  * <a href="#java">Java</a>      
  * <a href="#python">Python</a>
  * <a href="#r">R</a>
  * <a href="#ruby">Ruby</a>


<h2><a name="bash">Bash</a></h2>

Bash shell with GNU date and nanoseconds:

    date -u +"%Y-%m-%dT%H:%M:%S.%NZ"

Bash shell with BSD date and seconds:

    date -u +"%Y-%m-%dT%H:%M:%SZ"

Bash shell with BSD date to convert Unix epoch seconds:

    date -r 1000000000 -u +"%Y-%m-%dT%H:%M:%SZ"

Bash shell with BSD date to find files and print times:

    find . -type f -print0 | 
    xargs -0 stat -f"%m␟%N" |
    awk -F ␟ '{ ("date -r " $1 " -u +\"%Y-%m-%dT%H:%M:%SZ\"" | getline t); $1=t; print}' |
    sort -n


<h2><a name="c">C</a></h2>

C with ANSI C:

    #include <stdio.h>
    #include <time.h>
    
    int main()
    {
        time_t timer;
        char s[30];
        struct tm* tm_info;

        time(&timer);
        tm_info = localtime(&timer);

        strftime(s, 30, "%Y-%m-%d %H:%M:%S.000000000Z", tm_info);
        puts(s);

        return 0;
    }

C with struct timeval:

    #include <stdio.h>
    #include <sys/time.h>
    int main(void)
    {
        struct timeval t;
        gettimeofday(&t,NULL);
        printf("%ld.%09ld\n", (long int)t.tv_sec, (long int)t.tv_usec);
        return 0;
    }


<h2><a name="cpp">C++</a></h2>

C++:

    #include <iostream>

    int main() {
        time_t t;
        time(&t);
        char buf[sizeof "2011-10-08T07:07:09Z"];
        strftime(buf, sizeof buf, "%Y-%m-%dT%H:%M:%SZ", gmtime(&t));
        // Prefer this line if your compiler supports %F or %T formats:
        //strftime(buf, sizeof buf, "%FT%TZ", gmtime(&nt));
        std::cout << buf << "\n";
    }
    
C++ with Boost:

    #include <iostream>
    #include <boost/date_time/posix_time/posix_time.hpp>

    int main() {
        using namespace boost::posix_time;
        ptime t = microsec_clock::universal_time();
        std::cout << to_iso_extended_string(t) << "Z\n";
    }


<h2><a name="csharp">C#</a></h2>


C#:

    TODO


<h2><a name="elixir">Elixir</a></h2>

Elixir:

    TODO


<h2><a name="go">Go</a></h2>

Go:

    package main

    import "fmt"
    import "time"

    func main() {
        const f = "2006-01-02T15:04:05.999999999Z"
        t := time.Now().UTC()
        s := t.Format(format)
        fmt.Println(s)
    }


<h2><a name="haskell">Haskell</a></h2>

Haskell:

    TODO


<h2><a name="Java">Java</a></h2>

Java with seconds:

    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.TimeZone;

    public class DateTimeFormat {
      public static void main(String[] args) {
         String iso = "yyyy-MM-dd'T'HH:mm:ss.000000000'Z'";
         TimeZone tz = TimeZone.getTimeZone("UTC");
         DateFormat df = new SimpleDateFormat(iso);
         df.setTimeZone(tz);
         String s = df.format(new Date());
         System.out.println(s);
      }
    }

Java with Joda:

    DateTime dt = new DateTime();
    DateTimeFormatter iso = ISODateTimeFormat.dateTime();
    String str = fmt.print(dt);


<h2><a name="JavaScript">JavaScript</a></h2>

JavaScript with milliseconds:

    var t = new Date();
    var s = now.toISOString()
    console.log(s);


<h2><a name="perl">Perl</a></h2>

Perl with POSIX:

    use POSIX;
    my $F = "%Y-%m-%dT%H:%M:%S.000000000Z"
    my $t = time();
    print strftime($F, gmtime($t), "\n";

Perl with CPAN:

    use DateTime;
    my $t = DateTime->now()
    $now->iso8601().'Z';


<h2><a name="python">Python</a></h2>

Python:

    import datetime
    F = "%Y-%m-%dT%H:%M:%S.%f000Z" 
    t = datetime.datetime.utcnow()
    t.strftime(F)


<h2><a name="r">R</a></h2>

R:

    TODO


<h2><a name="ruby">Ruby</a></h2>

Ruby:

    F = "%Y-%m-%dT%H:%M:%S.%NZ"
    t = Time.now.utc
    puts t.strftime(F)


## Extras

Resources:

* [How to measure time in milliseconds using ANSI C?](http://stackoverflow.com/questions/361363/how-to-measure-time-in-milliseconds-using-ansi-c)


