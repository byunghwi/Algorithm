/**
 * @param {string} s
 * @return {boolean}
 */
var areOccurrencesEqual = function(s) {
    var result = true;
    var map = new Map();
    var idx = 0;
    var charArr = [...s];
    while(s.length > idx) {
       if(map.has(charArr[idx])) {
           map.set(charArr[idx], map.get(charArr[idx])+1)
       } else 
       map.set(charArr[idx], 1);

       idx++;
    }
    
    var values = map.values(); // 문자들 갯수 담겨있는 배열 ex) 2, 2, 2  / 2, 3, 5
    var delDuplicate = new Set(values); // 문자들 갯수 담겨있는 배열에서 중복 제거 

    return delDuplicate.size == 1;
};