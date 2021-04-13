printjson(db.people.find(
    {
        "birth_date" : {
            $gte: "2001-01-01T000:00:00Z",
            $lt: "2100-01-01T000:00:00Z"
        }
    },
    {
        first_name: 1,
        last_name: 1,
        "location.city": 1
    }).toArray()
)
