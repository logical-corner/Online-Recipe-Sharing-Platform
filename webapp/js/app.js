document.addEventListener("DOMContentLoaded", function () {

    const loginForm = document.getElementById("loginForm");

    if (loginForm) {

        loginForm.addEventListener("submit", function (event) {

            event.preventDefault();

            const email =
                document.getElementById("email").value;

            const password =
                document.getElementById("password").value;

            const message =
                document.getElementById("message");

            if (email === "" || password === "") {

                message.textContent =
                    "Please fill all fields.";

                message.className =
                    "text-center mt-4 text-red-600";

                return;
            }

            message.textContent =
                "Login form is ready.";

            message.className =
                "text-center mt-4 text-green-600";

        });

    }

});