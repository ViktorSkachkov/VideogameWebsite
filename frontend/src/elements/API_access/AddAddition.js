import axios from "axios";
import {useState} from "react";
import Cookies from "universal-cookie";

const AddAddition = (loggedUser) => {
    const [gameId, setGameId] = useState(1);
    const [image, setImage] = useState("image");
    const [name, setName] = useState();
    const [price, setPrice] = useState();
    const [description, setDescription] = useState();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    const onChangeDescription = event => {
        setDescription(event.target.value);
    }
    const onChangePrice = event => {
        setPrice(event.target.value);
    }
    const onChangeImage = event => {
        var reader = new FileReader();
        reader.onload = function (event) {
            setImage(event.target.result);
        };
        reader.readAsDataURL(event.target.files[0]);
    }
    const onChangeName = event => {
        setName(event.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "gameId": gameId,
            "image": image,
            "description": description,
            "price": price,
            "name": name,
        };
        axios.post(
            `http://localhost:8080/additions`,
            bodyParams,
            config
        )
            .then(function (response) {
                /*let mealName = response.data.mealName;
                navigate(`/successfullyUpdatedMeal/${mealName}`);*/
                alert('Addition successfully added!');
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    return (
        <>
            <center>
                <form onSubmit={handleSubmit}>
                    <br/><br/>
                    <label htmlFor="image" className="formLabelImage">Image</label><br/><br/>
                    <input type="file" name="image" onChange={onChangeImage} className="Label"/><br/><br/>
                    <label htmlFor="name" className="formLabelName">Name</label><br/>
                    <input type="text" name="name" onChange={onChangeName} value={name} className="Label" /><br/><br/>
                    <label htmlFor="username" className="formLabelDescription">Description</label><br/>
                    <textarea type="text" name="description" onChange={onChangeDescription} value={description} className="Label" /><br/><br/>
                    <label htmlFor="number" className="formLabelPrice">Price</label><br/>
                    <input type="number" name="price" onChange={onChangePrice} value={price} className="Label" /><br/><br/>
                    <button type="submit" className="normalButton">Submit</button>
                </form><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </center>
        </>
    )
}
export default AddAddition;