$(function(){

   dianJi();

});
function dianJi(){
    $("#btn").click(function(){
        var name=$("#name").val();
        var password=$("#password").val();
        $.post("/LoginController","name="+name+"&password="+password,function(data){
            console.log(data.companyAll)
            var arr = data.companyAll
            $.each(arr,function(index,company){
            $("#tab").append(`<tr>
                <td>${company.companyId}</td>
                <td>${company.contactPhone}</td>
            </tr>`)
                console.log(company)
            })
        },'json')
    })
}