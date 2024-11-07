from models import db


class Users(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.Text, nullable=False)
    address = db.Column(db.Text, nullable=False)
    birthday = db.Column(db.Date, nullable=False)
    phoneNumber = db.Column(db.BigInteger, unique=True, nullable=False)
    email = db.Column(db.Text, unique=True, nullable=False)
    position = db.Column(db.Text, nullable=False)
    salary = db.Column(db.BigInteger, nullable=False)
    password = db.Column(db.String(50), nullable=False)
    department = db.Column(db.Integer, nullable=True)
    isAdmin = db.Column(db.Boolean, nullable=False)

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "address": self.address,
            "birthday": self.birthday,
            "phoneNumber": self.phoneNumber,
            "email": self.email,
            "position": self.position,
            "salary": self.salary,
            "password": self.password,
            "department": self.department,
            "isAdmin": self.isAdmin,
        }
