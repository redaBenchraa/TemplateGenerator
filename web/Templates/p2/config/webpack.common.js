var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var helpers = require('./helpers');

module.exports = {
  entry: {
    'polyfills': './src/polyfills.ts',
    'vendor': './src/vendor.ts',
    'app': './src/main.ts',
    'css': './src/styles/main.scss'
  },

  resolve: {
    extensions: ['', '.js', '.ts', '.scss']
  },

  module: {
    loaders: [
      {
        test: /\.ts$/,
        loader: 'ts'
      },
      {
        test: /\.html$/,
        loader: 'html'
      },
      {
        test: /\.(png|jpe?g|gif|svg|woff|woff2|ttf|eot|ico)$/,
        loader: 'file?name=assets/[name].[hash].[ext]'
      },
      {
        test: /\.css$/,
        exclude: helpers.root('src', 'app'),
        loader: ExtractTextPlugin.extract('style', 'css?sourceMap')
      },
      {
        test: /\.css$/,
        include: helpers.root('src', 'app'),
        loader: 'raw'
      },
      // {
      //   test: /\.scss$/,
      //   exclude: /node_modules/,
      //   loader: 'raw-loader!sass-loader'
      // },
      { test: /^(?!.*component).*\.scss$/,
        exclude: /node_modules/,
        loaders: ['style', 'css', 'resolve-url', 'sass']
      },
      { test: /\.component\.scss$/,
        exclude: /node_modules/,
        loaders: ['raw', 'resolve-url', 'sass']
      },
    ]
  },

  plugins: [
    new webpack.optimize.CommonsChunkPlugin({
      name: ['app', 'vendor', 'polyfills', 'css']
    }),

    new HtmlWebpackPlugin({
      template: 'src/index.html'
    })
  ]
};
