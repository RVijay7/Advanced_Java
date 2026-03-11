let array = ["DevLens", "Speed Bot", "Speed boost", "JSON Wizard", "Tab master pro"];
let iconarray = ["fa-solid fa-camera", "fa-solid fa-fire", "fa-solid fa-stopwatch-20", "fa-solid fa-comment-nodes", "fa-solid fa-tablet"];
let parent = document.getElementById("grid-container");
for (i = 0; i < array.length; i++) {
    let ele = document.createElement("div");
    parent.appendChild(ele);
    ele.id = "gridelement";
    let text = document.createElement("div");
    ele.appendChild(text);
    text.id = "textarea"
    let icon = document.createElement("i");
    icon.setAttribute("class", iconarray[i]);
    icon.id = "icon";
    text.innerText = array[i];
    text.appendChild(icon);
    let botdiv = document.createElement("div");
    ele.appendChild(botdiv);
    let remove = document.createElement("button");
    remove.innerText = "Remove";
    remove.id = "rembut";
    botdiv.appendChild(remove);
    botdiv.id="bottomdiv";
    remove.addEventListener("click",function(){
        array.length=array.length-1;
        this.parentElement.parentElement.remove();
    })
    let toggle=document.createElement("i");
    toggle.id="tog";
    botdiv.appendChild(toggle);
    toggle.setAttribute("class","fa-solid fa-toggle-off");
    toggle.style="font-size:30px";
    toggle.addEventListener("click",function(){
        let but=this.getAttribute("class");
        if(but=="fa-solid fa-toggle-off"){
            toggle.setAttribute("class","fa-solid fa-toggle-on");
            this.setAttribute("var","0");
        }
        else if(but=="fa-solid fa-toggle-on"){
            toggle.setAttribute("class","fa-solid fa-toggle-off");
            this.setAttribute("var","1");
        }
        
    })
}
// let toggle=document.getElementById("tog");
document.getElementById("active").addEventListener("click",function(){
    let activearray=[];
 for(i=0;i<array.length;i++){
    let toggle=document.querySelectorAll("#tog")[i];
    // console.log(toggle);
    // console.log(toggle.getAttribute("class"));
    // console.log(toggle.getAttribute("var"));
    if(toggle.getAttribute("class")!=="fa-solid fa-toggle-off"){
        activearray.push(toggle.parentElement.previousElementSibling.innerText);
        // console.log(toggle.parentElement.previousElementSibling.innerText);
    }   
 }
 console.log(activearray);
 console.log("array",array,"activearray",activearray);
 for(j=0;j<array.length;j++){
    if(!activearray.includes(array[j])){
        // console.log(document.querySelectorAll("#tog")[j].parentElement.parentElement);
        document.querySelectorAll("#tog")[j].parentElement.parentElement.style="display:none";
        // console.log(document.querySelectorAll("#tog")[j].parentElement.parentElement);
    }
 }
})

document.getElementById("inactivebut").addEventListener("click",function(){
let inactivearray=[];
console.log(array);
 for(i=0;i<array.length;i++){
    let toggle=document.querySelectorAll("#tog")[i];
    // console.log(toggle);
    // console.log(toggle.getAttribute("class"));
    // console.log(toggle.getAttribute("var"));
    if(toggle.getAttribute("class")==="fa-solid fa-toggle-off"){
        inactivearray.push(toggle.parentElement.previousElementSibling.innerText);
        // console.log(toggle.parentElement.previousElementSibling.innerText);
    }   
 }
 console.log(inactivearray,array);
    for(j=0;j<array.length;j++){
        if(!inactivearray.includes(array[j])){
            document.querySelectorAll("#tog")[j].parentElement.parentElement.style="display:none";
        }
        else{
            document.querySelectorAll("#tog")[j].parentElement.parentElement.style="display:flex";
        }
     }
})
// document.getElementById("all").addEventListener("click",function(){
//     document.querySelectorAll("#tog")[j].parentElement.parentElement.style="display:flex";
// })