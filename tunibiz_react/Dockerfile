# Base image
FROM node:18 AS base

# Set working directory
WORKDIR /app

# Install dependencies
COPY package.json package-lock.json ./
RUN npm install

# Copy application code
COPY . .

# Build the application
RUN npm run build

# Development stage
FROM base AS dev
ENV NODE_ENV=development

# Expose the port
EXPOSE 3000

# Start the development server
CMD ["npm", "run", "dev"]

# Production stage
FROM base AS production
ENV NODE_ENV=production

# Expose the port for production
EXPOSE 3000

# Start the production server
CMD ["npm", "start"]
