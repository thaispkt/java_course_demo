function ajax_get(url, callback) {
  var xmlhttp = new XMLHttpRequest();
  xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
      callback(xmlhttp.responseText);
    }
  };

  xmlhttp.open("GET", url, true);
  xmlhttp.send();
}
function createUser() {
  $('#userForm').submit(function(e) {
    e.preventDefault();
    var userName = $('#name').val();
    var userJob = $('#job').val();

    $.ajax({
      url: 'https://reqres.in/api/users',
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify({ "name": userName, "job": userJob }),
      success: function(response) {
        console.log('User Created:', response);
        alert("User Created Successfully!");

        // Redirect to the root directory
        window.location.href = '/';
      },
      error: function(xhr, status, error) {
        console.error('Error in user creation:', status, error);
      }
    });
  });
}

$(document).ready(function() {
  createUser();
});

function get(url, callback) {
  $.ajax({
    url: url,
    type: "GET",
    success: function(response) {
      callback(response);
    }
  });
}

get('https://reqres.in/api/users', function(data) {
  console.log(data);
  var users = data.data;
  var tableBody = $('#userTable tbody');
  users.forEach(function(user) {
    var row = '<tr>' +
                '<td>' + user.id + '</td>' +
                '<td>' + user.email + '</td>' +
                '<td>' + user.first_name + '</td>' +
                '<td>' + user.last_name + '</td>' +
                '<td><img src="' + user.avatar + '" alt="' + user.first_name + '"></td>' +
              '</tr>';
    tableBody.append(row);
  });
});