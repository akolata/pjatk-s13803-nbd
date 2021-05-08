var mapFunctionNbd0401 = function () {
    var key = this.sex;
    var value = {
        avgWeight: parseFloat(this.weight),
        avgHeight: parseFloat(this.height),
        count: 1
    };
    return emit(key, value);
};

var reduceFunctionNbd0401 = function (key, value) {
    // value: Array<{avgWeight: number, avgHeight: number, count: number}>
    return {
        avgWeight: Array.sum(value.map(obj => obj.avgWeight)),
        avgHeight: Array.sum(value.map(obj => obj.avgHeight)),
        count: Array.sum(value.map(obj => obj.count))
    };
};

var finalizeFunctionNbd0401 = function (key, reducedVal) {
    // reducedVal: Array<{avgWeight: number, avgHeight: number, count: number}>
    return {
        avgWeight: reducedVal.avgWeight / reducedVal.count,
        avgHeight: reducedVal.avgHeight / reducedVal.count
    };
};

printjson(db.people.mapReduce(mapFunctionNbd0401, reduceFunctionNbd0401, {
    out: {inline: 1},
    finalize: finalizeFunctionNbd0401
}));
