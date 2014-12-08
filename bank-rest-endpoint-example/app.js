var express = require('express');
var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser.json());

var accounts = [
    {
        id: '1234',
        balance: 15489
    },
    {
        id: null,
        balance: 1234
    }
];

app.post('/', function (req, res)
{

    var id = req.body.id;

    var account = null;
    accounts.forEach(function (element)
    {
        if (element.id === id)
        {
            account = element;
        }
    });

    if (!account)
    {
        return res.status(412).json({message: 'No account exists with id = ' + id});
    }

    res.json(account);
});

app.listen(4321);
console.log('app listening on port 4321');
