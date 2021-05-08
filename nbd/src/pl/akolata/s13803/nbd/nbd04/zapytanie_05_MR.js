var mapFunctionNbd0405 = function () {
    this.credit.forEach(credit => {
        var key = credit.currency;
        var value = {
            totalBalance: parseFloat(credit.balance),
            averageBalance: parseFloat(credit.balance),
            count: 1
        }
        emit(key, value);
    });
};

var reduceFunctionNbd0405 = function (key, values) {
    // value: Array<{totalBalance: number, averageBalance: number, count: number}>
    var balanceValues = values.map(values => values.totalBalance); // all 3 properties have the same value after 'map' step
    var totalBalance = Array.sum(balanceValues);
    return {
        totalBalance: totalBalance,
        averageBalance: totalBalance,
        count: Array.sum(values.map(values => values.count))
    };
};

var finalizeFunctionNbd0405 = function (key, reducedVal) {
    // value: Array<{totalBalance: number, averageBalance: number, count: number}>
    return {
        totalBalance: reducedVal.totalBalance,
        averageBalance: reducedVal.totalBalance / reducedVal.count
    };
};

db.people.mapReduce(
    mapFunctionNbd0405,
    reduceFunctionNbd0405,
    {
        out: "peopleNBD0405",
        query: {
            sex: "Female",
            nationality: "Poland"
        },
        finalize: finalizeFunctionNbd0405
    }
);
printjson(db.peopleNBD0405.find().sort({_id: 1}).toArray());
