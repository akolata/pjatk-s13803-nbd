var mapFunctionNbd0401 = function () {
    var key = this.sex;
    var value = {
        avgWeight: parseFloat(this.weight),
        avgHeight: parseFloat(this.height)
    };
    return emit(key, value);
};

var reduceFunctionNbd0401 = function (key, value) {
    // value: Array<{avgWeight: number, avgHeight: number}>
    var sumOfWeight = value.map(obj => obj.avgWeight);
    var sumOfHeight = value.map(obj => obj.avgHeight);
    return {
        avgWeight: Array.sum(sumOfWeight) / value.length,
        avgHeight: Array.sum(sumOfHeight) / value.length
    };
};

printjson(db.people.mapReduce(mapFunctionNbd0401, reduceFunctionNbd0401, {out: {inline: 1}}))