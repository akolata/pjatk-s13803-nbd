var mapFunctionNbd0402 = function () {
    this.credit.forEach(credit => {
        var key = credit.currency;
        var value = parseFloat(credit.balance)
        emit(key, value);
    });
};

var reduceFunctionNbd0402 = function (key, values) {
    // value: Array<number>
    return Array.sum(values);
};

printjson(db.people.mapReduce(mapFunctionNbd0402, reduceFunctionNbd0402, {out: {inline: 1}}));
