var mapFunctionNbd0404 = function () {
    var convertedHeightInM = parseFloat(this.height) / 100;
    var convertedWeight = parseFloat(this.weight);
    var bmi = convertedWeight / (convertedHeightInM * convertedHeightInM);
    var value = {
        minBmi: bmi,
        avgBmi: bmi,
        maxBmi: bmi
    };
    emit(this.nationality, value);
};

var reduceFunctionNbd0404 = function (key, values) {
    // value: Array<{minBmi: number, avgBmi: number, maxBmi: number}>
    var bmiValues = values.map(values => values.avgBmi); // all 3 properties have the same value after 'map' step
    return {
        minBmi: Math.min.apply(Math, bmiValues),
        avgBmi: Array.sum(bmiValues) / bmiValues.length,
        maxBmi: Math.max.apply(Math, bmiValues)
    };
};

db.people.mapReduce(mapFunctionNbd0404, reduceFunctionNbd0404, {out: "peopleNBD0404"});
printjson(db.peopleNBD0404.find().sort({_id: 1}).toArray());
