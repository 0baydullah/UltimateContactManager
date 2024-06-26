console.log("script loaded")

let currentTheme=getTheme();
console.log(currentTheme);

changeTheme();


// change theme function

function changeTheme(){
    // set to wweb page
    changePageTheme(currentTheme,currentTheme);

    //set the listener to change theme button
    const changeThemeButton =document.querySelector("#theme_change_button");
    

    changeThemeButton.addEventListener("click", ()=>{
        let oldTheme = currentTheme;
        console.log("change theme button clicked");
        if(currentTheme=== "dark"){
            currentTheme = "light";
        } else{
            currentTheme = "dark";
        }

        changePageTheme(currentTheme,oldTheme);
    });
}


/// set theme to local storage

function setTheme(theme){
    localStorage.setItem("theme",theme);
}


/// get tehme to local storage 

function getTheme(){
    let theme = localStorage.getItem("theme");
    if(theme) return theme;
    else return "light";
}

function changePageTheme(theme,oldTheme){
    // update in local storage
    setTheme(currentTheme);
    //removing old theme
    document.querySelector("html").classList.remove(oldTheme);
    // set the current theme
    document.querySelector("html").classList.add(theme);

    // change the text of the button 
    document.querySelector("#theme_change_button").querySelector("span").textContent = theme == "light"?"Dark":"Light";
}