$(document).ready(function(){
    //logic code
//    alert("Test")
    $(".btn-xoa").click(function() {
//        alert("Test 123")
        var id = $(this).attr("role-id")
        var This = $(this)
        // Gọi đường dẫn và lấy dữ liệu từ path đó trả ra
        $.ajax({
          method: "DELETE",
          url: "http://localhost:8080/api/role?id=" + id,
//          data: { name: "John", location: "Boston" } chỉ dành cho method POST
        }).done(function( result ) {
            if(result.data == true) {
//            This.parent().parent() // lay td, tr
                This.closest("tr").remove()
            }
            console.log(result)
        });
    })
})