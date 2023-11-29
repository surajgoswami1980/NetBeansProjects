/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function onclickmenu(){
    document.getElementById("menu").classList.toggle("icon");
    document.getElementById("nav").classList.toggle("change");
}
function registerstudent(){
    document.getElementById("registerstudent");
    window.location.href="addnewstudent.html";
    
}
function home(){
    document.getElementById("home");
    
    window.location.href="admininterface.html";
}
function waitingstudents(){
    document.getElementById("waitingstudents");
    window.location.href="pendingstudents.html";
}
function approvedstudents(){
    document.getElementById("approvedstudents");
    window.location.href="studentdetails.html";
}
function allbook(){
    document.getElementById("allbook");
    window.location.href="admininterface.html";
}
function addbook(){
    document.getElementById("addbook");
    window.location.href="admininterface.html";
}
function issuebook(){
    document.getElementById("issuebook");
    window.location.href="admininterface.html";
}
function returnbook(){
    document.getElementById("return");
    
    window.location.href="admininterface.html";
}
function registeradmin(){
    document.getElementById("registeradmin");
    window.location.href="addnewadmin.html";
}
function logout(){
    document.getElementById("logout");
    window.location.href="index.html";
}
function profile(){
    document.getElementById("profile");
    window.location.href="profile.html";
}





