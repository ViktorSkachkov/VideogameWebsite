import {useParams} from "react-router-dom";
import {useState, useEffect} from "react";
import axios from "axios";
import '../css/ViewGame.css';
import Cookies from "universal-cookie";

const ViewGame = (loggedUser) => {
    const [game, setGame] = useState(null);
    const [review, setReview] = useState(null);
    let params = useParams();
    const id = params.id;

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getVideogame();
    }, []);
    const handleSubmit = (e) => {

    };
    const getVideogame = () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/videogames/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                setGame(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    };
    const onChangeReview = event => {
        setReview(event.target.value);
    }

    return (
        <>
            {game != null ?
                <div className="viewGameBody">
                    <center>
                        <img src="/69piR5.jpg" width="80%" height="400px"  alt="Currently the image can't load"/>
                        <h1>{game.name}</h1>
                        <p>{game.description}</p>
                        <button>Buy</button>
                        <form onSubmit={handleSubmit}>
                            <label htmlFor="review" className="review">Review</label><br/>
                            <input onChange={onChangeReview} name="review" type="number" className="Label"/><br/>
                            <button>Submit Review</button><br/><br/>
                        </form>
                    </center>
                </div> :
                <p>Loading...</p>}
        </>
    )
}
export default ViewGame;