var mapFunctionNbd0405 = function () {
    this.credit.forEach(credit => {
        var key = credit.currency;
        var value = {
            totalBalance: parseFloat(credit.balance),
            averageBalance: parseFloat(credit.balance)
        }
        emit(key, value);
    });
};

var reduceFunctionNbd0405 = function (key, values) {
    // value: Array<{totalBalance: number, averageBalance" number}>
    var balanceValues = values.map(values => values.totalBalance); // all 2 properties have the same value after 'map' step
    var totalBalance = Array.sum(balanceValues);
    return {
        totalBalance: totalBalance,
        averageBalance: totalBalance / values.length
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
        }
    }
);
printjson(db.peopleNBD0405.find().sort({_id: 1}).toArray());
