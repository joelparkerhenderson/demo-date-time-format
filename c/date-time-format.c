#include <stdio.h>
#include <sys/time.h>
int main(void)
{
  struct timeval time_now;
  gettimeofday(&time_now,NULL);
  printf ("%ld secs, %ld usecs\n",time_now.tv_sec,time_now.tv_usec);
  return 0;
}
