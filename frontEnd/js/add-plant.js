fetch(`http://localhost:8080/api/plants`, {
    method: "GET",
    headers: {
    "Content-Type": "application/json",
},
})
.then(response => response.json())
.then(plants => generateDropdown(plants))
.catch(error => console.log(error));


const generateDropdown = function(plants){
    let select = document.getElementById("dropdown");

    plants.forEach(plant => {
        let option = document.createElement("option");
        option.classList.add("choose-plant");
        option.innerText = plant.name;
        select.appendChild(option);
    });
    return select;
    

}


export {generateDropdown}

