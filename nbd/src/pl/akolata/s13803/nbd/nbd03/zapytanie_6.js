printjson(db.people.insert(
    {
        "sex" : "Male",
        "first_name" : "Aleksander",
        "last_name" : "Kołata",
        "job" : "Full stack Java Developer",
        "email" : "s13803@pjatk.edu.pl",
        "location" : {
            "city" : "Warsaw",
            "address" : {
                "streetname" : "Koszykowa",
                "streetnumber" : "86"
            }
        },
        "description" : "1st year student",
        "height" : "176.00",
        "weight" : "72.0",
        "birth_date" : "1995-08-12T06:00:00Z",
        "nationality" : "Poland",
        "credit" : [
            {
                "type" : "jcb",
                "number" : "6376881458117617",
                "currency" : "PLN",
                "balance" : "5408.84"
            }
        ]
    }
))
