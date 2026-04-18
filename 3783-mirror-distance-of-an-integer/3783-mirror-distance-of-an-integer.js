/**
 * @param {number} n
 * @return {number}
 */
var mirrorDistance = function(n) {
    var rev=0;
    var og=n;

    while(n>0){
        rev=rev*10+n%10;
        n=Math.floor(n/10);
    }
    return Math.abs(rev-og);
};
