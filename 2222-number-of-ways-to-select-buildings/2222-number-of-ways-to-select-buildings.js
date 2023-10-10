/**
 * @param {string} s
 * @return {number}
 */
var numberOfWays = function(s) {
    //가능한 조합 010, 101 이므로
    // 현재 인덱스의 숫자 이전의 반대되는 숫자들 갯수(ex 현재 1이라면 현재 인덱스 이전의 0인 숫자의 갯수) * 현재 인덱스의 숫자 이후의 반대되는 숫자들 갯수

    var totalZeros = 0; // 전체 0의 갯수
    var totalOnes = 0;  // 전체 1의 갯수
    var leftZeros = 0; // 현재 인덱스 숫자 이전의 0의 갯수
    var leftOnes = 0;  // 현재 인덱스 숫자 이전의 1의 갯수
    var arrChar = [...s]; // 문자 배열
    var result = 0; // 결과값

    // totalZeros, totalOnes 세팅
    for(var i=0; i<arrChar.length; i++) {
        if(arrChar[i] == '1') {
            totalOnes += 1;
        } else {
            totalZeros += 1;
        }
    }

    leftZeros = (arrChar[0] == '0') ? 1 : 0;
    leftOnes =  (arrChar[0] == '1') ? 1 : 0;

    for(var j=1; j<arrChar.length; j++) {
        if(arrChar[j] == 0) { //현재 인덱스 값 0일 때, 좌측의 값이 1인 인덱스들 갯수 * 우측의 값이 1인 인덱스들 갯수
            result = result + (leftOnes * (totalOnes - leftOnes));
            leftZeros++;
        } else { // 현재 인덱스 값 1일 때, 좌측의 값이 0인 인덱스들 갯수 * 우측의 값이 0인 인덱스들 갯수
            result = result + (leftZeros * (totalZeros - leftZeros));
            leftOnes++;
        }
    }

    return result;
};
