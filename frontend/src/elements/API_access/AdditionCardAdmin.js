import {useNavigate} from "react-router-dom";
import axios from "axios";
import '../css/AdditionCardAdmin.css';
import Cookies from "universal-cookie";

const AdditionCardAdmin = (addition) => {
    let navigate = useNavigate();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    function deleteAddition(id) {
        var config = {
            method: "delete",
            url: `http://localhost:8080/additions/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                alert('Addition successfully deleted!');
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    return (
        <div className="additionArticleCard">
            <div>
                <img src="69piR5.jpg" height="300px" width="450px" alt=""/>
            </div>
            <div>
                <h1>{addition.addition.name}</h1>
                <p className="text">{addition.addition.description}</p>
                <button onClick={() => deleteAddition(addition.addition.id) }>Remove</button> <button onClick={() => {
                navigate(`/updateAddition/${addition.addition.id}`, {

                });
            }}>Update</button>
            </div>
        </div>
    )
}
export default AdditionCardAdmin;