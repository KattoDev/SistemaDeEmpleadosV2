from flask import Blueprint, request, jsonify
from models import user as userModel, db

user_bp = Blueprint("get_user", __name__)


# ------------------------------------------------------------------------------
# --------------------------------- method get ---------------------------------
# ------------------------------------------------------------------------------
@user_bp.route("/", methods=["GET"])
def get_users():
    users = userModel.Users.query.all()
    if not users:
        return jsonify({"message": "no users"}), 200
    return jsonify([user.to_dict() for user in users]), 200


@user_bp.route("/<int:user_id>", methods=["GET"])
def get_user(user_id):
    user = db.session.get(userModel.Users, user_id)

    if not user:
        return jsonify({"mensaje": "usuario no encontrado"}), 404

    return jsonify([user.to_dict()]), 200


@user_bp.route("/<email>-<password>", methods=["GET"])
def search_user_by_email_and_password(email, password):
    user = (
        db.session.query(userModel.Users)
        .filter(userModel.Users.email == email, userModel.Users.password == password)
        .first()
    )

    if user:
        return jsonify([user.to_dict()]), 200
    else:
        return jsonify({"mensaje": "usuario no encontrado"}), 404


# ------------------------------------------------------------------------------
# --------------------------------- method post --------------------------------
# ------------------------------------------------------------------------------
@user_bp.route("/", methods=["POST"])
def create_user():
    try:
        required_fields = [
            "name",
            "address",
            "birthday",
            "phoneNumber",
            "email",
            "position",
            "salary",
            "password",
            "isAdmin",
        ]
        data = request.get_json()

        for field in required_fields:
            if field not in data:
                return {"message": f"{field} is required"}, 404

        new_user = userModel.Users(
            name=data["name"],
            address=data["address"],
            birthday=data["birthday"],
            phoneNumber=data["phoneNumber"],
            email=data["email"],
            position=data["position"],
            salary=data["salary"],
            password=data["password"],
            department=data.get("department", None),
            isAdmin=data["isAdmin"],
        )

        db.session.add(new_user)
        db.session.commit()

        return (jsonify(new_user.to_dict())), 200

    except Exception as e:
        return jsonify({"message": "An error occurred", "error": str(e)}), 500


# -------------------------------------------------------------------------------
# -------------------------------- method update --------------------------------
# -------------------------------------------------------------------------------
@user_bp.route("/<int:user_id>", methods=["PATCH"])
def patch_user(user_id):
    try:
        data = request.get_json()

        user = userModel.Users.session.get(user_id)

        if user is None:
            return jsonify({"message": "user not found"}), 404

        if "name" in data:
            user.name = data["name"]
        if "address" in data:
            user.address = data["address"]
        if "birthday" in data:
            user.birthday = data["birthday"]
        if "phoneNumber" in data:
            user.phoneNumber = data["phoneNumber"]
        if "email" in data:
            user.email = data["email"]
        if "position" in data:
            user.position = data["position"]
        if "salary" in data:
            user.salary = data["salary"]
        if "password" in data:
            user.password = data["password"]
        if "department" in data:
            user.department = data["department"]
        if "isAdmin" in data:
            user.isAdmin = data["isAdmin"]

        db.session.commit()
        return jsonify(user.to_dict()), 200

    except Exception as e:
        return jsonify({"message": "an error ocurred", "error": str(e)}), 500


# -------------------------------------------------------------------------------
# -------------------------------- method delete --------------------------------
# -------------------------------------------------------------------------------
@user_bp.route("/<int:user_id>", methods=["DELETE"])
def delete_user(user_id):
    try:
        user = userModel.Users.session.get(user_id)

        if user is None:
            return jsonify({"message": "user not found"}), 404

        db.session.delete(user)
        db.session.commit()

        return jsonify({"message": "Users deleted successfully"}), 200

    except Exception as e:
        return jsonify({"message": "Cannot delete user", "error": str(e)}), 500
