function generatePortfolio() {

    let name = document.getElementById("name").value;
    let title = document.getElementById("title").value;
    let email = document.getElementById("email").value;
    let about = document.getElementById("about").value;
    let education = document.getElementById("education").value;
    let experience = document.getElementById("experience").value;
    let skills = document.getElementById("skills").value.split(",");

    /* validation */

    if (name == "" || title == "" || email == "") {
        alert("Please fill all required fields");
        return;
    }

    /* insert values */

    document.getElementById("pName").innerText = name;
    document.getElementById("pTitle").innerText = title;
    document.getElementById("pEmail").innerText = email;
    document.getElementById("pAbout").innerText = about;
    document.getElementById("pEducation").innerText = education;
    document.getElementById("pExperience").innerText = experience;

    /* skills */

    let skillList = document.getElementById("pSkills");
    skillList.innerHTML = "";

    skills.forEach(skill => {
        let li = document.createElement("li");
        li.innerText = skill.trim();
        skillList.appendChild(li);
    });

    /* image */

    let file = document.getElementById("image").files[0];

    if (file) {

        let reader = new FileReader();

        reader.onload = function (e) {
            document.getElementById("pImage").src = e.target.result;
        }

        reader.readAsDataURL(file);

    }

    /* show portfolio */

    document.getElementById("formPage").style.display = "none";
    document.getElementById("portfolioPage").style.display = "block";

    window.scrollTo(0, 0);

}