angular.module('atmApp')
    .factory('VerifyPin', ['$http', function ($http)
    {
        return {
            verify: function (accountNumber, pinNumber)
            {

                var account = {
                    accountNumber: accountNumber,
                    pin: pinNumber
                };

                //return $http.get('http://10.21.24.124:8080/api/' + accountNumber + '/' + pinNumber);
                return $http.post('http://10.21.24.126:8081/presentation-1.0.0-SNAPSHOT/api/authenticate', account);
            }
        }
    }]);