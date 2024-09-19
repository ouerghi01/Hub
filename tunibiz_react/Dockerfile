# Step 1: Use an official Node.js image as the base
FROM node:18-alpine

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Step 4: Install dependencies
RUN npm install --silent

# Step 5: Copy the rest of the app's code to the working directory
COPY . .

# Step 6: Build the React app for production
RUN npm run build

# Step 7: Use a lightweight web server to serve the production build
FROM nginx:alpine
COPY --from=0 /app/build /usr/share/nginx/html

# Step 8: Expose the port Nginx will use
EXPOSE 80

# Step 9: Start Nginx when the container starts
CMD ["nginx", "-g", "daemon off;"]

