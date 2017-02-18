# Demo Date Time UTC ISO format

This demo shows:

  * How to print a date-time string.
  * Using the UTC time zone, also known as +00:00, or GMT, or Zulu time.
  * Using the ISO 8601 extended format, because it's easy to read.

Example:

    2020-01-01T00:00:00.000+00:00

Meaning:

  * `YYYY-MM-DD` means the year, month, and day.
  * `T` is the ISO standard separator character between the date and tiem.
  * `HH:MM:SS.sss` means the hour, minute, second, and millisecond.
  * `+00:00` means zero offset from UTC, in other words, actual UTC time.

Preferences:

  * We like the extended format because it's easy for a person to skim.
  * We prefer using a `T` separator over a blank because of machine parsing.
  * We prefer using fractional seconds over just seconds because of precision.
  * We prefer `+00.00` over `Z` because our logs contain many time zones.
  
Coding conventions in this repo.

  * `t` is the time.
  * `F` is the format string.
  * `s` is the output string.
  
Examples:

  * <a href="#bash">Bash</a>
  * <a href="#c">C</a>
  * <a href="#cpp">C++</a>
  * <a href="#elixir">Elixir</a>
  * <a href="#go">Go</a>
  * <a href="#java">Java</a>      
  * <a href="#python">Python</a>
  * <a href="#ruby">Ruby</a>


<h2><a name="bash">Bash</a></h2>

Bash shell with GNU date and nanoseconds:

    date -u +"%Y-%m-%dT%H:%M:%S.%N+00:00"

Bash shell with BSD date and seconds:

    date -u +"%Y-%m-%dT%H:%M:%S+00:00"

Bash shell with BSD date to convert Unix epoch seconds:

    date -r 1000000000 -u +"%Y-%m-%dT%H:%M:%S+00:00"

Bash shell with BSD date to find files and print times:

    find . -type f -print0 | 
    xargs -0 stat -f"%m␟%N" |
    awk -F ␟ '{ ("date -r " $1 " -u +\"%Y-%m-%dT%H:%M:%S+00:00\"" | getline t); $1=t; print}' |
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

        strftime(s, 30, "%Y-%m-%d %H:%M:%S.000000000+00:00", tm_info);
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
        printf("%ld.%09ld+00:00\n", (long int)t.tv_sec, (long int)t.tv_usec);
        return 0;
    }


<h2><a name="cpp">C++</a></h2>

C++:

    #include <iostream>

    int main() {
        time_t t;
        time(&t);
        char buf[sizeof "2011-10-08T07:07:09+00:00"];
        strftime(buf, sizeof buf, "%Y-%m-%dT%H:%M:%S+00:00", gmtime(&t));
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


<h2><a name="elixir">Elixir</a></h2>

Elixir with the Timex library:

    use Timex
    t=Timex.now("UTC") 
    Timex.format(t, "{ISO:Extended}")


<h2><a name="go">Go</a></h2>

Go:

    package main

    import "fmt"
    import "time"

    func main() {
        const f = "2006-01-02T15:04:05.999999999+00:00"
        t := time.Now().UTC()
        s := t.Format(format)
        fmt.Println(s)
    }


<h2><a name="Java">Java</a></h2>

Java with seconds:

    import java.text.DateFormat;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.TimeZone;

    public class DateTimeFormat {
      public static void main(String[] args) {
         String iso = "yyyy-MM-dd'T'HH:mm:ss'.000000000+00:00'";
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
    var s = now.toISOString().slice(0, -1) + "+00:00"
    console.log(s);


<h2><a name="perl">Perl</a></h2>

Perl with POSIX and seconds:

    use POSIX;
    my $F = "%Y-%m-%dT%H:%M:%S+00:00"
    my $t = time();
    print strftime($F, gmtime($t), "\n";

Perl with CPAN:

    use DateTime;
    my $t = DateTime->now()
    $now->iso8601().'+00:00';


<h2><a name="python">Python</a></h2>

Python with microseconds:

    import datetime
    F = "%Y-%m-%dT%H:%M:%S.%f+00:00" 
    t = datetime.datetime.utcnow()
    t.strftime(F)


<h2><a name="ruby">Ruby</a></h2>

Ruby:

    F = "%Y-%m-%dT%H:%M:%S.%N+00:00"
    t = Time.now.utc
    puts t.strftime(F)
