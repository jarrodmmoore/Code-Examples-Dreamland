#Jarrod Moore
#Section B
#Description: This program calculates long-term payments for loans from user inputted data, then offers financial advice based on their income

#get inputs from user
principal = float(input("Enter your principal or amount borrowed in USD (ex: 2500.00): "))
rate = float(input("Enter your yearly interest rate (ex: 0.05): "))
years = int(input("Enter the number of years you will need to repay the loan: "))

#calculations
#important that we find annual first since that can then be used to find monthly and lifetime payment
annual = float((((1 + rate) ** years) * principal * rate) / (((1 + rate) ** years) - 1)) 
monthly = float(annual / 12)
total = float(annual * years)

#show calculated rates and lifetime payment, formatted nicely
print("\n")
print("Monthly Payment is ${0:,.2f}".format(monthly))
print("Yearly Payment is ${0:,.2f}".format(annual))
print("Total Payment is ${0:,.2f}".format(total))
print("\n")

#get annual income and use that to find monthly
income = float(input("What is your annual income? (ex: 35000.00): "))
income_month = float(income / 12)
print("\n")

#offer advice based on the monthly income vs monthly payment
if (income_month < monthly):
    if (rate > 0.05):
        print("You need to refinance your loan!")
    else:
        print("You should seek financial counseling.")
else:
    print("If you make all of your payments, you should have the loan payed without any trouble.")