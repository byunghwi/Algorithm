/**
 * @param {number} day
 * @param {number} month
 * @param {number} year
 * @return {string}
 */
var dayOfTheWeek = function(day, month, year) {
    var dayOfTheWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

    return dayOfTheWeek[new Date(year + '-' + month + '-' + day).getDay()];
};