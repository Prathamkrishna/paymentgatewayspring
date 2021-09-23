let state = false;
let stateVal;
function clickPayment(e){
    console.log(e)
    if(!state){
        document.getElementById("root").appendChild(document.createTextNode("Enter Details"))
        document.getElementById("root").appendChild(document.createElement("br"))
        let div = document.createElement("span")
        div.id = e.id + "a"
        div.innerHTML = e.id + " number"
        document.getElementById("root").appendChild(div)
        document.getElementById("root").appendChild(document.createElement("input"))
        state = true
        stateVal = e.id + "a"
        document.getElementById("root").appendChild(document.createElement("br"))
        let button = document.createElement("button")
        let text = document.createTextNode("button")
        button.onclick = function(){
            window.location.href = "http://localhost:8080/"
        }
        button.appendChild(text);
        document.getElementById("root").appendChild(button)
        // document.getElementById("app").appendChild(document.createElement("button").appendChild(document.createTextNode("click")))
    }
    else {
        if(e.id + "a" === stateVal){
            console.log("here")
        }
        else {
            console.log("not")
            document.getElementById(stateVal).innerHTML = e.id + " number"
            document.getElementById(stateVal).id = e.id + "a"
            stateVal = e.id + "a"
        }
    }
}