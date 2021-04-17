var mapFunctionNbd0401 = function () {
    var key = this.sex;
    var value = parseFloat(this.weight);
    return emit(key, value);
};

var reduceFunctionNbd0401 = function (key, value) {
    return Array.sum(value)/value.length;
};

printjson(db.people.mapReduce(mapFunctionNbd0401, reduceFunctionNbd0401, {out: {inline : 1}}))