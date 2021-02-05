fetch(`http://localhost:8080/api/catalog/5`, {
    method: "GET",
    headers: {
        "Content-Type": "application/json",
    },
})
.then(response => response.json())
.then(cards => fillPage(cards))
.catch(error => console.log(error));



const fillPage = function(cards){
    let owned = document.createElement("div")
    owned.id = "owned"
    console.log("step 1")

    cards.forEach(card => {

    let cardDiv = document.createElement("div");
    cardDiv.classList.add("plant");
    let plantHeader = document.createElement("aside");
    plantHeader.classList.add("plant-header");
    let plantName = document.createElement("h2");
    plantName.classList.add("plant-name");
    plantName.innerText = card.name;
    let light = document.createElement("img");
    light.classList.add("light");
    light.alt = "light needs";
    light.innerText = card.light;
    plantHeader.appendChild(plantName);
    plantHeader.appendChild(light);
    cardDiv.appendChild(plantHeader);

    let plantInfo = document.createElement("aside");
    plantInfo.classList.add("plant-info");
    let plantImage = document.createElement("img");
    plantImage.classList.add("image");
    plantImage.alt = "plant photo";
    plantImage.src = card.plantImage;
    let water = document.createElement("p");
    water.classList.add("water");
    water.innerText = card.water;
    let notes = document.createElement("p");
    notes.classList.add("notes");
    notes.innerText = card.notes;
    plantInfo.appendChild(plantImage);
    plantInfo.appendChild(water);
    plantInfo.appendChild(notes);
    cardDiv.appendChild(plantInfo);

    owned.appendChild(cardDiv);
});
return owned;
}

export {fillPage}