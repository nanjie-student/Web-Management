function ajaxGet(url,params,callback) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
            if(xhr.status==200){
                callback(xhr.responseText);
            }
        }
    }
    xhr.open("GET",params?url+"?"+params:url,true);
    xhr.send(null);
}
function ajaxPost(url,params,callback) {//add
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
            if(xhr.status==200){
                callback(xhr.responseText);
            }
        }
    }
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(params);
}
function ajaxPut(url,params,callback) {//update
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
            if(xhr.status==200){
                callback(xhr.responseText);
            }
        }
    }
    xhr.open("PUT",url,true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(params);
}
function ajaxDelete(url,params,callback) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4){
            if(xhr.status==200){
                callback(xhr.responseText);
            }
        }
    }
    xhr.open("delete",params?url+"?"+params:url,true);
    xhr.send(null);
}