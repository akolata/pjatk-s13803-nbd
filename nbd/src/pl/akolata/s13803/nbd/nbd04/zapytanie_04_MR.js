var mapFunctionNbd0404 = function () {
    var convertedHeightInM = parseFloat(this.height) / 100;
    var convertedWeight = parseFloat(this.weight);
    var bmi = convertedWeight / (convertedHeightInM * convertedHeightInM);
    var value = {
        minBmi: bmi,
        avgBmi: bmi,
        maxBmi: bmi,
        count: 1
    };
    emit(this.nationality, value);
};

var reduceFunctionNbd0404 = function (key, values) {
    // value: Array<{minBmi: number, avgBmi: number, maxBmi: number, count: number}>
    var bmiValues = values.map(values => values.avgBmi); // all 4 properties have the same value after 'map' step
    return {
        minBmi: Math.min.apply(Math, bmiValues),
        avgBmi: Array.sum(bmiValues),
        maxBmi: Math.max.apply(Math, bmiValues),
        count: Array.sum(values.map(obj => obj.count))
    };
};

var finalizeFunctionNbd0404 = function (key, reducedVal) {
    // reducedVal: Array<{minBmi: number, avgBmi: number, maxBmi: number, count: number}>
    return {
        minBmi: reducedVal.minBmi,
        avgBmi: reducedVal.avgBmi / reducedVal.count,
        maxBmi: reducedVal.maxBmi
    };
};

db.people.mapReduce(mapFunctionNbd0404, reduceFunctionNbd0404, {
    out: "peopleNBD0404",
    finalize: finalizeFunctionNbd0404
});
printjson(db.peopleNBD0404.find().sort({_id: 1}).toArray());
