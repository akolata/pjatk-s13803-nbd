var mapFunctionNbd0403 = function () {
    emit(this.job, this.job);
};

var reduceFunctionNbd0403 = function (key, values) {
    // value: Array<string>
    return values[0];
};

printjson(db.people.mapReduce(mapFunctionNbd0403, reduceFunctionNbd0403, {out: {inline: 1}}));
