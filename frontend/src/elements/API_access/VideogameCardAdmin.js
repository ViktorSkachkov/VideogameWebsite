import {useNavigate} from "react-router-dom";
import '../css/VideogameCardAdmin.css';
import axios from "axios";
import {useState} from "react";
import Cookies from "universal-cookie";

const VideogameCardAdmin = (videogame) => {

    let navigate = useNavigate();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    function deleteGame(id) {
        var config = {
            method: "delete",
            url: `http://localhost:8080/videogames/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                alert('Videogame successfully deleted!');
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    return (
        <div className="videogameArticleCard">
            <div>
                <img src="69piR5.jpg" height="300px" width="450px" alt=""/>
            </div>
            <div>
                <h1>{videogame.videogame.name}</h1>
                <p className="text">{videogame.videogame.description}</p>
                <button onClick={() => deleteGame(videogame.videogame.id) }>Remove</button> <button onClick={() => {
                navigate(`/updateVideogame/${videogame.videogame.id}`, {

                });
            }}>Update</button>
            </div>
        </div>
    )
}
export default VideogameCardAdmin;