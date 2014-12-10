angular.module('atmApp')
    .factory('PayBill', ['$http', 'ServiceAPI', 'Account', function ($http, ServiceAPI, Account)
    {
        return {
            pay: function (bill) {
                return $http({
                    url: ServiceAPI.url + '/api/payments',
                    method: 'POST',
                    headers: {
                        Authorization: Account.getToken()
                    },
                    data: bill
                });
            }
        }
    }]);