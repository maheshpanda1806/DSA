# Defining functions
def circle():
    radius = int(input("Enter The Radius of The Circle: "))
    area = 3.14 * radius * radius
    circum = 2 * 3.14 * radius
    print(f"Area is {area} and circumference is {circum}")
    
def cylinder():
    radius = int(input("Enter The Radius: "))
    height = int(input("Enter The height: "))
    sur_area = (2 * 3.14 * radius * radius) + (2 * 3.14 * radius * height)
    volume = 3.14 * radius * radius * height
    print(f"Surface Area is {sur_area} and volume is {volume}")

def cone():
    r = int(input("Enter The smaller Radius: "))
    R = int(input("Enter The bigger Radius: "))
    h = int(input("Enter the Height: "))
    l = int(input("Enter the slant Height: "))

    volume = (1/3) * 3.14 * h * (r*r + R*R + r*R)
    TSA = 3.14 * l * (R + r) + 3.14 * (R*R + r*r)
    print(f"Total Surface Area is {TSA} and volume is {volume}")

def sphere():
    radius = int(input("Enter The Radius: "))
    sur_area = 4 * 3.14 * radius ** 2
    volume = (4/3) * (3.14 * radius ** 3)
    print(f"Surface Area is {sur_area} and volume is {volume}")

def cube():
    side = int(input("Enter The side: "))
    volume = side ** 3
    sur_area = 6 * side ** 2
    print(f"Surface Area is {sur_area} and volume is {volume}")

def exit_program():
    print("Exiting the program.")
    exit()

def main():
    menu_options = {
        1: circle,
        2: cylinder,
        3: cone,
        4: sphere,
        5: cube,
        6: exit_program
    }
    
    while True:
        print("\nMAIN MENU")
        print("1. Area and circumference of a circle.")
        print("2. Volume and surface area of a cylinder")
        print("3. Volume and surface area of a cone")
        print("4. Volume and surface area of a sphere")
        print("5. Volume and surface area of a cube")
        print("6. Exit")

        choice = int(input("Enter the Choice(1-6): "))
        if choice in menu_options:
            menu_options[choice]()
        else:
            print("Invalid choice. Please enter a number between 1 and 6.")
            
if __name__ == "__main__":
    main()

    


   
            
