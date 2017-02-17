/* Run:
 * 
 *     $ node date-time-format.js
 *     2020-01-01T00:00:00.000Z
 */
var now = new Date();
var s = now.toISOString()
console.log(s);
