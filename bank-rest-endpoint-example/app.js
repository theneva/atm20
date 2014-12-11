var express = require('express');
var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser.json());

var pendingPayments = {
    "3E0E6762-C942-48FD-9E97-7184DABEB29D": {
        "kid": "23423423",
        "dueDate": "2014-12-10",
        "amount": 437,
        "recipientNickname": "Ã˜l til Martin",
        "recipientAccountNumber": "12312312312"
    }, "CCDA2752-5DB5-4670-9A79-E6E480E84445": {
        "kid": "6756763454",
        "dueDate": "2014-12-14",
        "amount": 100,
        "recipientNickname": "Chess",
        "recipientAccountNumber": "27834793902"
    }, "AF738456-9A71-4EB5-BD57-38C45D535CFA": {
        "id": "",
        "kid": "34728972",
        "dueDate": "2014-12-14",
        "amount": 5439,
        "recipientNickname": "Ny telefon",
        "recipientAccountNumber": "78378493842"
    }
};

app.get('/', function (req, res) {
    res.json(pendingPayments);
});

app.post('/', function (req, res) {
    var id = req.body.id;

    console.log(id);

    var pendingPayment = pendingPayments[id];

    if (!pendingPayment) {
        return res.status(412).json({message: 'No pending payment exists with id = ' + id});
    }

    res.json(pendingPayment);
});

app.listen(4321);
console.log('app listening on port 4321');
